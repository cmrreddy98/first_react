import React from 'react';
import {BrowserRouter as Router,Switch,Route,Link} from 'react-router-dom';
import Footer from './Components/Footer';
import NavigationBar from './Components/NavigationBar';
import DateSelection from './Components/dateSelection';
import Login from './Components/Login';
import Transactions from './Components/Transactions';
export default function App() {
  return (
    <Router>

      <Switch><Route path="/" exact component={Login} /></Switch>
      <Switch><Route path="/a" exact component={DateSelection} /></Switch>
      <Switch><Route path="/b" exact component={Transactions} /></Switch>
      
    
      
      <Footer/>
    </Router>  
  );
}