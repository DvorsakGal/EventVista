import React, {useState, useEffect} from "react";
import api from "../../services/api";
import { Link } from "react-router-dom";
import {TextField,Button} from "@mui/material"
import { useNavigate } from 'react-router-dom';



function Login(){
    const[Username,setUsername]=React.useState("");
    const[Password,setPassword]=React.useState("");
    const navigate = useNavigate();

    const login = () => {
        api.post("/auth/login", {
            Username: Username,
            Password:Password,
        }).then((result) => {
            console.log(result.data)
            if (result.data.jwt=="") {
                navigate('/Eventi')
            }
        })
        .catch((error) => {
            console.error('Error during login:', error);
            // Handle errors as needed
        });
    }
    
    

    return(
        <div style={{margin: "20px",textAlign: `center`}}>
            <div>
                <h1>Login</h1>
                <div>
                    <TextField id="outlined-basic" label="Username" variant="outlined" onChange={(event) => setUsername(event.target.value)}/>
                </div>
                <div>
                    <TextField id="outlined-basic" label="Password" variant="outlined" onChange={(event) => setPassword(event.target.value)}/>    
                </div>
                <div style={{margin:"10px"}}>
                    <Button onClick={login} variant="contained">Login</Button>  
                </div>
                
            </div>
            <div>
            <h1>Se nisi registriran?</h1>
            <Link to="/registracija"><Button variant="contained">Registracija</Button></Link>
            </div>
             
        </div>
    )
}

export default Login;