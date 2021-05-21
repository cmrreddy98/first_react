import React,{Component} from 'react';
import  './DateSelection.css';
import Transactions from './Transactions';
import NavigationBar from './NavigationBar';
export default class DateSelection extends Component{
    constructor(props){
        super();
        this.state={
            date: "",
            bool:true
        };
    }

     selectdate=()=>{
        sessionStorage.setItem("date", this.state.date)
        this.setState({bool:false})
    }
    render(){
            return (
              <div>

                {this.state.bool ?
                <div>
                <NavigationBar/>
                <div className="main">
                    <input className="un" align="center" type="date" value={this.state.date} onChange={(event)=> this.setState
                        ({date:event.target.value})
                    } />
                    <br/>
                    <button className="submit" onClick={this.selectdate}  >Select Date</button>
                </div>
                </div>
                : <Transactions/> }
              </div>
            );
    }
}
