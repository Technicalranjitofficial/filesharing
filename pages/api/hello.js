import { data } from 'autoprefixer';

// import micro from 'micro';
const formidable = require('formidable');

async function handler(req, res) {

	console.log("hi");
  
const data = await new Promise(function (resolve, reject) {
  const form = new formidable.IncomingForm({ keepExtensions: true,uploadDir:"uploads/",filename: (name, ext, part, form) => {
	return part.originalFilename.replace(" ",""); // Will be joined with options.uploadDir.
} });





  form.parse(req, function (err, fields, files) {
    if (err) return reject(err);

	// console.log(files.file.filepath);
    resolve({ fields, files });
  });
});


// console.log(data['files'].file)

// console.log(`/upload/${data['files'].file.newFilename}`);
// res.json({filepath:`/upload/${data['files'].file.newFilename}`});

res.json({filepath:data['files'].file.filepath});

}



  
export const config = {
  api: {
    bodyParser: false,
  },
};

export default handler