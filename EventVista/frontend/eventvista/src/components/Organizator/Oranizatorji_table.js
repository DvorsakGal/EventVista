import React from "react";
import api from "../../services/api";
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import odstrani_organizatorja from "./odstrani_organizatorja";

export default function Oranizatorji_table({organizatorji}) {
    return(
        <TableContainer component={Paper}>
            <Table sx={{ minWidth: 650 }} aria-label="simple table">
                <TableHead>
                <TableRow>
                    <TableCell>Id</TableCell>
                    <TableCell align="right">ime</TableCell>
                    <TableCell align="right">priimek</TableCell>
                    <TableCell align="right">email</TableCell>
                    <TableCell align="right">telefon</TableCell>
                    <TableCell align="right">Odstrani_organizatorja</TableCell>
                </TableRow>
                </TableHead>
                <TableBody>
                {organizatorji.map((organizator) => (
                    <TableRow
                    key={organizator.id}
                    sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                    >
                    <TableCell component="th" scope="row">
                        {organizator.id}
                    </TableCell>
                    <TableCell align="right">{organizator.ime}</TableCell>
                    <TableCell align="right">{organizator.priimek}</TableCell>
                    <TableCell align="right">{organizator.email}</TableCell>
                    <TableCell align="right">{organizator.telefon}</TableCell>
                    <TableCell align="right">{<button onClick={() => odstrani_organizatorja(organizator.id)}>Delete</button>}</TableCell>
                    </TableRow>
                ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
}

