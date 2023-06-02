import { NextApiRequest, NextApiResponse } from "next";
import os from "os";
import path from "path";

const fs = require("fs");

export default async function handler(req,res){
    // res.json("hello")

    fs.readdir(path.join(process.cwd(),"/public/uploads"),(err,files)=>{
        res.json(files);
    })


    // console.log(path.join(homedir,"./public"));

    // res.json(process.cwd());



    
}