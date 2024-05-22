import React, { useEffect, useState } from "react";
import api from "../../services/api";


/*
export default function OdstraniEvent({id}){
    console.log(id);
    api.delete(`/events/${id}`)
    .then((result) => console.log(result.data))
    .catch((error) => console.error('Error deleting event:', error));
}
*/
const odstraniEvent = (eventId) => {
    api.delete(`/events/${eventId}`)
      .then((result) => console.log(result.data))
      .catch((error) => console.error('Error deleting event:', error));
  };

  export default odstraniEvent;

