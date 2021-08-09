import React from 'react';
import { useFormik } from 'formik';
import * as Yup from 'yup';
import './AccountCreation.css';

export default function AccountCreation() {
    const phoneRegExp = /^((\\+[1-9]{1,4}[ \\-])|(\\([0-9]{2,3}\\)[ \\-])|([0-9]{2,4})[ \\-])?[0-9]{3,4}?[ \\-]*[0-9]{3,4}?$/;
    const emailRegExp = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    const passRegExp = /^(?=.\d)(?=.[a-z])(?=.*[A-Z]).{8,32}$/;
    const userRegExp = /^(?=.[a-z])(?=.[0-9])(?=.*[A-Z]).{8,32}$/;


    const validationSchema = Yup.object({
        fname: Yup.string().required("Firstname is mandatory"),
        lname: Yup.string().required("Lastname is mandatory"),
        email: Yup.string().matches(emailRegExp, "Email is Invalid"),
        age: Yup.number().typeError("Enter a valid age").min(20, " Mini Age is 20").max(90, "Max age is 90"),
        phone: Yup.string().matches(phoneRegExp, "Phone number is invalid"),
        uname: Yup.string().matches(userRegExp, "Username is invalid"),
        password: Yup.string().matches(passRegExp, "Password is invalid")
    })


    const { handleSubmit, handleChange, values, errors } = useFormik({
        initialValues: {
            fname: '',
            lname: '',
            age: 0,
            email: '',
            phone: '',
            uname: '',
            password: ''
        },
        validationSchema,
        onSubmit(values) {
            console.log("=============Submitted");
            console.log(values);
        }
    })
    return (
        <div class="container">
            <div class="content">
                <h2>Account Creation</h2>
                <form onSubmit={handleSubmit} noValidate>
                    <div>
                        <tr>
                            <td> <label>First Name </label></td>
                            <td> <input type="text" name="fname" onChange={handleChange} values={values.fname} /></td>
                            {errors.fname ? errors.fname : null}
                        </tr>
                    </div>
                    <div>
                        <tr><td> <label>Last Name</label></td>
                            <td> <input type="text" name="lname" onChange={handleChange} values={values.lname} /></td>
                            {errors.lname ? errors.lname : null}
                        </tr></div>

                    <div>
                        <tr> <td> <label>Age</label></td>
                            <td> <input type="number" name="age" onChange={handleChange} values={values.age} /></td>
                            {errors.age ? errors.age : null}
                        </tr>  </div>

                    <div>
                        <tr> <td>  <label>Email</label></td>
                            <td> <input type="text" name="email" onChange={handleChange} values={values.email} /></td>
                            {errors.email ? errors.email : null}
                        </tr> </div>

                    <div>
                        <tr><td>  <label>Phone Number</label></td>
                            <td>  <input type="text" name="phone" onChange={handleChange} values={values.phone} /></td>
                            {errors.phone ? errors.phone : null}
                        </tr> </div>

                    <div>
                        <tr> <td> <label>Username</label></td>
                            <td> <input type="text" name="uname" onChange={handleChange} values={values.uname} /></td>
                            {errors.uname ? errors.uname : null}
                        </tr>  </div>

                    <div>
                        <tr>  <td><label>Password</label></td>
                            <td>    <input type="password" name="password" onChange={handleChange} values={values.password} /></td>
                            {errors.password ? errors.password : null}
                        </tr>  </div>

                    <button type="submit" >Submit</button>
                </form>
            </div>
        </div>
    )
}

