import React, { Component } from 'react';
import {Navbar, Nav ,NavDropdown} from 'react-bootstrap'
import {Link} from 'react-router-dom';

class NavigationBar extends Component {
    render() {
        return (
            <div>
                <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark">
                    <Nav className="mr-auto">
                    <Link to={"a"} className="nav-link">Select Date</Link>
                    <Link to={"b"} className="nav-link">Result</Link>
                    </Nav>
                    <Nav >
                    <Link className="nav-link" eventKey={2} to={""}>Logout</Link>
                    </Nav>
                    
                </Navbar>
            </div>
        );
    }
}

export default NavigationBar;