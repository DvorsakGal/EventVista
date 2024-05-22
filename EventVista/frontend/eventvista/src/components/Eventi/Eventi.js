import { Button } from "@mui/material";
import React, { useEffect, useState } from "react";
import api from "../../services/api";
import { Link } from "react-router-dom";
import EventiTable from "./EventiTable";
import Navbar from "../navbar/navbar";
/*
const Eventi = () =>{
    return(
        <div>
            <h1>Eventi</h1>
        </div>
    );
}*/
// zgornja const in spodnja function sta enaki
function Eventi(){

    const [events, setEventi]=useState([]);

    useEffect(()=>{
        const pridobiEvente= ()=>{
            api.get("/events").then((response)=>{
                setEventi(response.data);
                console.log(response.data);
            });
        }
        pridobiEvente();
    }, [])

    return(
        <div style={{margin: "20px"}}>
            <div>
                {Navbar()}
                
            </div>
            <div>
                <h1>Eventi</h1>
                <Link to="/Eventi/dodaj"><Button variant="contained">Dodaj se kak event</Button></Link>
                <EventiTable events={events} />
            </div>
            
        </div>
    );
}
/*
<h2>
<p>aaa</p>
    {
        events.map((Event)=>{
            <li key={Event.id}>{Event.Ime},{Event.organizator}</li>
        })
        
    }
    <p>aaa</p>
</h2>
*/

export default Eventi;