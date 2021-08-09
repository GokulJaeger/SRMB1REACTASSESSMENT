import React from 'react'
import './AdminLogin.css';
export default function AdminLogin() {
    return (
        <div className="loginbody">
        <div class="login-box">
            <h2>ADMIN</h2>
            <form>
                <div class="user-box">
                    <input type="text" name="username"  />
                    <label className="lbl">Username</label>
                </div>
                <div class="user-box">
                    <input type="password" name="passord"  />
                    <label>Password</label>
                </div>
                <a href="#">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    Submit
                </a>
            </form>
        </div>
     </div>
    )
}
