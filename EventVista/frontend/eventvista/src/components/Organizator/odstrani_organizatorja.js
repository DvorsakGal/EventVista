import React, { useEffect, useState } from "react";
import api from "../../services/api";


const odstrani_organizatorja = (id_organizator) => {
    api.delete(`/organizatorji/${id_organizator}`)
      .then((result) => console.log(result.data))
      .catch((error) => console.error('Error deleting organizator:', error));
  };

  export default odstrani_organizatorja;

