import React from "react";
import api from "../../services/api";
import {TextField,Button} from "@mui/material"
import Navbar from "../navbar/navbar";

function Dodaj_Organizator(){
    const[ime,setIme]=React.useState("");
    const[organizator,setpriimek]=React.useState("");
    const[email,setemail]=React.useState("");
    const[telefon,settelefon]=React.useState("");

    const dodaj_organizator = () => {
        api.post("/organizatorji", {
            ime: ime,
            organizator: organizator,
            email:email,
            telefon:telefon,
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
                <div style={{margin:"5px"}}><TextField id="outlined-basic" label="priimek" variant="outlined"  value={organizator} onChange={(event) => setpriimek(event.target.value)}/>    
                </div>
                <div style={{margin:"5px"}}><TextField id="outlined-basic" label="email" variant="outlined"  value={email} onChange={(event) => setemail(event.target.value)}/>    
                </div>
                <div style={{margin:"5px"}}><TextField id="outlined-basic" label="telefon" variant="outlined"  value={telefon} onChange={(event) => settelefon(event.target.value)}/>    
                </div>
                <div style={{margin:"10px"}}><Button onClick={dodaj_organizator} variant="contained">Dodaj organizatorja</Button> </div>
            </div>
                  
        </div>
    )
}
export default Dodaj_Organizator;