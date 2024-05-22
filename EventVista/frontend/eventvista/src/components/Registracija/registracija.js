import React, {useState, useEffect} from "react";
import api from "../../services/api";
import { Link} from "react-router-dom";
import {TextField,Button} from "@mui/material"
import { useNavigate } from 'react-router-dom';


function Registriraj(){
    const[Username,setUsername]=React.useState("");
    const[Email,setEmail]=React.useState("");
    const[Password,setPassword]=React.useState("");
    const navigate = useNavigate();

    const registriraj = () => {
        api.post("/auth/register", {
            username: Username,
            email: Email,
            password:Password,
        }).then((result) =>{
            console.log(result.data);            
            if (result.data.id>=0) {
                navigate('/Eventi')
            }
        })
        .catch((error) => {
            console.error('Error during registration:', error);
            // Handle errors as needed
        }); 
    }
    
    

    return(
        <div style={{margin: "20px",textAlign: `center`}}>
            <div>
                <h1>Registracija</h1>
                <div>
                    <TextField id="outlined-basic" label="Username" variant="outlined" onChange={(event) => setUsername(event.target.value)}/>
                </div>
                <div>
                    <TextField id="outlined-basic" label="Email" variant="outlined" onChange={(event) => setEmail(event.target.value)}/>    
                </div>
                <div>
                    <TextField id="outlined-basic" label="Password" variant="outlined" onChange={(event) => setPassword(event.target.value)}/>    
                </div>
                <div style={{margin:"10px"}}>
                    <Button onClick={registriraj} variant="contained">Registriraj</Button>  
                </div>
                
            </div>
            <div>
            <h1>Si ze registriran?</h1>
            <Link to="/login"><Button variant="contained">Login</Button></Link>
            </div>
             
        </div>
    )
}

export default Registriraj;