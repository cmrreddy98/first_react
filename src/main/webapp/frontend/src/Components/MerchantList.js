import React,{Component} from 'react';
import axios from 'axios';
import './MerchantList.css';
export default class MerchantList extends Component{
    constructor(props){
        super();
        this.state={
            txns:[]
        };
    }

    componentDidMount(){
    var data={
        "date":sessionStorage.getItem("date")
    }
        axios.post("http://localhost:8080/transactionbymerchants",data)
            .then(response=>response.data)
            .then((data)=>{
                this.setState({txns:data});
            });
    }

    render(){
            return (
              <div className="responsive-tab">
              <table >
               <thead>
                     <tr>
                         <th scope="col">Merchant Name</th>
                         <th scope="col">Successful</th>
                         <th scope="col">Failure</th>
                         <th scope="col">Pending</th>
                     </tr>
               </thead>
               <tbody>
               {this.state.txns.length==0?
                    <tr align="center">
                        <td colSpan="6">No Merchants Available</td>
                    </tr>:
                    this.state.txns.map((d) =>
                         <tr>
                             <td>{d.name}</td>
                             <td>{d.success}</td>
                             <td>{d.failure}</td>
                             <td>{d.pending}</td>
                         </tr>
                    )
               }
               </tbody>
               </table>


              </div>
            );
    }
}
