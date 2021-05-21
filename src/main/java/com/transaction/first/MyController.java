package com.transaction.first;
import java.io.IOException;
import java.util.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class MyController {

	@Autowired
	TransactionRepo repo;

	@GetMapping("/")
	String index(Model model){
		return "/index";
	}


	@GetMapping("/login")
	String login(Model model){
		model.addAttribute("loginDetails", new LoginDetails());
		return "/Login";
	}
	@GetMapping("/transac")
	 List<Transaction> getList(){
		List<Transaction> l=repo.findAll();
		return l;
	}
	@PostMapping("/dates")
	public String getDates() {
		return "result";
	}

	@GetMapping("/selectdate")
	public String selectdate() {
		return "dateselection";
	}

	@PostMapping("/transactionbymerchants")
	public List<Merchant> getMerchant(@RequestBody String data){
		String date="";
		try {
			JSONObject jsonobj = new JSONObject(data);
			System.out.println(jsonobj.getString("date"));
			date=jsonobj.getString("date");
		}
		catch (Exception e){
			System.out.println("error");
		}
		List<Transaction> l2= repo.findAll();
		int size= l2.size();
		HashMap<String,int[]> merchantlist=new HashMap<>();
		for(int i=0;i<size;i++) {
			String s=l2.get(i).getCreated_date();
			s=s.substring(0,10);
			if(s.equals(date)) {
				String orgcode=l2.get(i).getOrg_code();
				if(!merchantlist.containsKey(orgcode)){
					merchantlist.put(orgcode,new int[3]);
				}
				int[] a=merchantlist.get(orgcode);
				if(l2.get(i).getStatus().equals("SUCCESS")){
					a[0]=a[0]+1;
				}
				else if(l2.get(i).getStatus().equals(("FAILURE"))){
					a[1]=a[1]+1;
				}
				else{
					a[2]=a[2]+1;
				}
			}
		}
		List<Merchant> merlist=new ArrayList<>();
		for(Map.Entry<String,int[]> code:merchantlist.entrySet()){
			int a[]=code.getValue();
			Merchant mer=new Merchant(a[0],a[1],a[2],code.getKey());
			merlist.add(mer);
		}
		return merlist;
	}

	@PostMapping("/transactions")
	public List<Statuscount> getAllTransactions(@RequestBody String data){//@ModelAttribute Dateclass date,Model model) {
		String date="";
		try {
			JSONObject jsonobj = new JSONObject(data);
			System.out.println(jsonobj.getString("date"));
			date=jsonobj.getString("date");
		}
		catch (Exception e){
			System.out.println("error");
		}
		System.out.println(data);
		List<Transaction> l2= repo.findAll();
		int success=repo.findByDate(date,"SUCCESS");
		int failure=repo.findByDate(date,"FAILURE");
		int pending=repo.findByDate(date,"PENDING");
		List<Statuscount> l=new ArrayList<>();
		Statuscount Success=new Statuscount("Success",success);
		Statuscount Failure=new Statuscount("Failure",failure);
		Statuscount Pending=new Statuscount("Pending",pending);
		l.add(Success);
		l.add(Failure);
		l.add(Pending);
		return l;
	}
	@PostMapping("/loginDetails")
	public String greetingSubmit(@RequestBody String data,Model model) {
		String username="";
		String password="";
		System.out.println("data received");
		try {
			JSONObject jsonobj = new JSONObject(data);
			username=jsonobj.getString("username");
			password=jsonobj.getString("password");
		}
		catch (Exception e){
			System.out.println("error");
		}
		LoginDetails loginDetails=new LoginDetails(username,password);
		model.addAttribute("loginDetails", loginDetails);
		try {
			Post.POSTRequest(loginDetails);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JSONObject json=Post.getJson();
		try {
			System.out.println(json.getBoolean("success"));
			if(json.getBoolean("success")){
				return "true";
			}
			else{
				return "false";
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "false";
	}
}




