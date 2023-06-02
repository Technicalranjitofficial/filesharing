'use client';

import axios from 'axios';
import React, { useState } from 'react'


const page = () => {


  // const [link,setlink] = useState("empty");

  const [file,setFile] = useState();
  const handleOnSubmit=async(e)=>{
    e.preventDefault();


    const formData = new FormData();
    formData.append("file",file);



    


 
    try {
      const response = await axios.post('http://localhost:3000/api/hello', formData, {
        onUploadProgress: (progressEvent) => {
          const progress = Math.round((progressEvent.loaded / progressEvent.total) * 100);
          console.log(progress)
        },
      });

      console.log(response.data);

      // setlink(response.data.filepath);
      // Reset the form
      setSelectedFile(null);
      setUploadProgress(0);
    } catch (error) {
      console.error(error);
    }

    console.log(file)
  }
  return (
   <>
   

   <form onSubmit={(e)=>handleOnSubmit(e)} encType='multipart/form-data' >

    <input type="file" name="file" id="file"  onChange={(e)=>setFile(e.target.files[0])}/>
    <input type="submit" />
   </form>


  {/* <a href={link}>{link}</a> */}
   
   </>
  )
}

export default page