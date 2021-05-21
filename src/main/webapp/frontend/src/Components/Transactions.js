import React,{Component} from 'react';
import axios from 'axios';
//import './Transactions.css';
import MerchantList from './MerchantList';
import './Trans.css'
import NavigationBar from './NavigationBar';
export default class Transactions extends Component{
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
        axios.post("http://localhost:8080/transactions",data)
            .then(response=>response.data)
            .then((data)=>{
                this.setState({txns:data});
            });
    }

    render(){
        const listItems = this.state.txns.map((d) =>
        <div className="Boxout">
            <td className="box"><h4>{d.type}</h4>
            <h1>{d.count}</h1></td>
        </div>
        );
            return (
              <div>
              <NavigationBar/>
              {listItems }
              <br/>
              <br/>
              <h1> Transactions Based on Merchants</h1>
              <MerchantList/>
              </div>

            );
    }
}
