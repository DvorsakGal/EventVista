import { Button } from "@mui/material";
import React, { useEffect, useState } from "react";
import api from "../../services/api";
import { Link } from "react-router-dom";
import Oranizatorji_table from "./Oranizatorji_table";
import Navbar from "../navbar/navbar";

function Organizatorji(){

    const [organizatorji, setorganizatorji]=useState([]);

    useEffect(()=>{
        const pridobiOrganizatorje= ()=>{
            api.get("/organizatorji").then((response)=>{
                setorganizatorji(response.data);
                console.log(response.data);
            });
        }
        pridobiOrganizatorje();
    }, [])

    return(
        <div style={{margin: "20px"}}>
            <div>
                {Navbar()}
                
            </div>
            <div>
                <h1>Eventi</h1>
                <Link to="/Organizator/dodaj"><Button variant="contained">Dodaj organizatorja</Button></Link>
                <Oranizatorji_table organizatorji={organizatorji} />
            </div>
            
        </div>
    );
}

export default Organizatorji;