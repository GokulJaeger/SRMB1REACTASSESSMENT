import React from 'react'
import './NavBar.css';

export default function Navbar() {
    return (
        // <div className="navbody">
        <div>
            <input type='checkbox' id='mmeennuu' />
            <label class='menu' for='mmeennuu'>

                <div class='barry'>
                    <span class='bar'></span>
                    <span class='bar'></span>
                    <span class='bar'></span>
                    <span class='bar'></span>
                </div>

                <ul>
                    <li><a id='home' href='/AccountCreation'>Account Creation</a></li>
                    <li><a id='about' href='/AccoountList'>Account List</a></li>
                    <li><a id='contact' href='/'>Logout</a></li>
                    <li><a id='link' href='/'>Other</a></li>
                </ul>

            </label>
            </div>
        // </div>
    )
}
