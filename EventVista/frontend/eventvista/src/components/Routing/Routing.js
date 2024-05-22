import react from "react";
import {Routes} from "react-router-dom";
import {Route} from "react-router";
import Eventi from "../Eventi/Eventi";
import PageNotFound from "../PageNotFound/PageNotFound";
import Registriraj from "../Registracija/registracija";
import DodajEvent from "../Eventi/dodajEvent";
import Login from "../login/login";
import Dodaj_Organizator from "../Organizator/DodajOrganizatorja";
import Organizatorji from "../Organizator/Organizatorji";

export default function Routing(){
    return(
        <Routes>
            <Route path="/" element={<Eventi />}></Route>
            <Route path="/Eventi" element={<Eventi />}></Route>
            <Route path="/Eventi/dodaj" element={<DodajEvent />}></Route>
            <Route path="/registracija" element={<Registriraj />}></Route>
            <Route path="/login" element={<Login />}></Route>
            <Route path="/Organizator" element={<Organizatorji />}></Route>
            <Route path="/Organizator/dodaj" element={<Dodaj_Organizator />}></Route>
            <Route path="*" element={<PageNotFound />}></Route>
        </Routes>
    );
}