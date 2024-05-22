import React from "react";
import api from "../../services/api";
import {TextField,Button} from "@mui/material"
import Navbar from "../navbar/navbar";

function DodajEvent(){
    const[ime,setIme]=React.useState("");
    const[organizator,setorganizator]=React.useState("");

    const dodajEvent = () => {
        api.post("/events", {
            ime: ime,
            organizator: organizator,
        }).then((result) => console.log(result.data));
    }



    return(
        <div style={{margin:"20px"}}>
            <div>
                {Navbar()}
                
            </div>
            <div style={{textAlign:"center"}}>
                <div><h1>Dodaj Event</h1></div>
                <div style={{margin:"5px"}}><TextField id="outlined-basic" label="ime" variant="outlined" value={ime} onChange={(event) => setIme(event.target.value)}/>
                </div>
                <div style={{margin:"5px"}}><TextField id="outlined-basic" label="organizator" variant="outlined"  value={organizator} onChange={(event) => setorganizator(event.target.value)}/>    
                </div>
                <div style={{margin:"10px"}}><Button onClick={dodajEvent} variant="contained">Dodaj Event</Button> </div>
            </div>
                  
        </div>
    )
}
export default DodajEvent;