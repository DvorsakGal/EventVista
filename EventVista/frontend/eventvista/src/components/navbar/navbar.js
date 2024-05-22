import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import { Link} from "react-router-dom";

import Menu from '@mui/joy/Menu';
import MenuButton from '@mui/joy/MenuButton';
import MenuItem from '@mui/joy/MenuItem';
import Dropdown from '@mui/joy/Dropdown';
/*
export default function MyApp() {
  return (
    a
  );
}*/

export default function Navbar() {
  return (
    

    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar>
            <Dropdown>
                <MenuButton>EventVista</MenuButton>
                <Menu>
                    <MenuItem><Link to="/Eventi/dodaj"><Button variant="contained" color="inherit">Dodaj_Event</Button></Link></MenuItem>
                    <MenuItem><Link to="/Eventi"><Button variant="contained" color="inherit">Eventi</Button></Link></MenuItem>
                    <MenuItem><Link to="/Organizator"><Button variant="contained" color="inherit">Organizatorji</Button></Link></MenuItem>
                </Menu>
            </Dropdown>
            <div style={{ flexGrow: 1 }}></div>
            <Dropdown>
                <MenuButton>Prijava</MenuButton>
                <Menu style={{alignItems:'center'}}>
                    <MenuItem><Link to="/registracija"><Button variant="contained" color="inherit">Registracija</Button></Link></MenuItem>
                    <MenuItem><Link to="/login"><Button variant="contained" color="inherit">Login</Button></Link></MenuItem>
                </Menu>
            </Dropdown>
        </Toolbar>
      </AppBar>
    </Box>
  );
}