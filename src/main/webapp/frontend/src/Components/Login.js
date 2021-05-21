import React,{Component} from 'react';
import  './DateSelection.css';
import axios from 'axios';
import DateSelection from './dateSelection';
import {withRouter} from 'react-router-dom';

export default class Login extends Component{
    constructor(props){
        super(props);
        this.state={
            username: "",
            password:"",
             bool:true
        };
    }

     logindetails=(event)=>{
        var data={
                "username":this.state.username,
                "password":this.state.password
            }
            console.log(data);
        axios.post("http://localhost:8080/loginDetails",data).then(response=>{
                    this.setState({
                        bool:!response.data
                    })
                    if(!response.data){
                        alert("Invalid Credentials")
                    }
        });


    event.preventDefault();
    }
    render(){
            return (
                 <div>
                {this.state.bool?
                <div className="main">
                    <p className="sign" align="center">Sign in</p>
                        <form  onSubmit={this.logindetails}>
                          <input className="un " type="text" align="center" value={this.state.username} onChange={(event)=> this.setState({username:event.target.value})}  required placeholder="Username"/>
                          <input className="pass" type="password" align="center" value={this.state.password} onChange={(event)=> this.setState({password:event.target.value})} required placeholder="password"/>
                          <input className="submit" align="center" type="submit" />
                        </form>
                </div>
                :<DateSelection/>}
                </div>

            );
    }
}
