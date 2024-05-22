import React from "react";
import api from "../../services/api";
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import odstraniEvent from "./odstraniEvent";
import { useNavigate } from 'react-router-dom';

export default function EventiTable({events}) {
    const navigate = useNavigate();
    return(
        <TableContainer component={Paper}>
            <Table sx={{ minWidth: 650 }} aria-label="simple table">
                <TableHead>
                <TableRow>
                    <TableCell>Id</TableCell>
                    <TableCell align="right">cas</TableCell>
                    <TableCell align="right">datum</TableCell>
                    <TableCell align="right">ime</TableCell>
                    <TableCell align="right">interes</TableCell>
                    <TableCell align="right">organizator</TableCell>
                    <TableCell align="right">prijavljeneUporabnike</TableCell>
                    <TableCell align="right">Odstrani_event</TableCell>
                </TableRow>
                </TableHead>
                <TableBody>
                {events.map((event) => (
                    <TableRow
                    key={event.id}
                    sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                    >
                    <TableCell component="th" scope="row">
                        {event.id}
                    </TableCell>
                    <TableCell align="right">{event.cas}</TableCell>
                    <TableCell align="right">{event.datum}</TableCell>
                    <TableCell align="right">{event.ime}</TableCell>
                    <TableCell align="right">{event.interes}</TableCell>
                    <TableCell align="right">{event.organizator}</TableCell>
                    <TableCell align="right">{event.prijavljeneUporabnike}</TableCell>
                    <TableCell align="right">
                        {<button onClick={() => {
                            odstraniEvent(event.id)
                            window.location.reload();}}>
                        Delete
                    </button>}</TableCell>
                    </TableRow>
                ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
}

