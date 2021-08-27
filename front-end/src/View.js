import React, { useEffect, useState } from "react";
import "./View.css";
import axios from 'axios';
import Lista from "./components/Lista.js"

export default function View() {
    const [file, setFile] = useState(undefined)

    function setFileInput(file) {
        console.log(file)
        setFile(file)
    }

    function uploadFile() {
        console.log("dentro do upload file")
        const data = new FormData()
        data.append('file', file)
        
        console.log()
        axios.post('http://localhost:8080/arquivos/upload', data, {headers: {
            "Content-type": "multipart/form-data"
          }})
      .then(res => { // then print response status
        console.log(res)
      })
    }

    return (
        <div>
            <input type="file" name="file" onChange={e => setFileInput(e.target.files[0])} />
            <button onClick={ () => uploadFile()}>Enivar arquivo</button>
            <Lista />
        </div>
    )
}