const express = require("express");
const path = require("path");
const fs = require("fs");

const app = express();
const PORT = 4200;

// Serve static files from 'public' directory
app.use(express.static(path.join(__dirname, "public")));

// API endpoint to fetch file content dynamically
app.get("/:file_name", (req, res) => {
  const fileName = req.params.file_name; // Get filename from URL
  const filePath = path.join(__dirname, "public", fileName); // Construct file path

  // Check if file exists
  fs.readFile(filePath, "utf8", (err, data) => {
    if (err) {
      return res.status(404).json({ error: "File not found" });
    }
    res.send(data); // Send file content
  });
});

// Start the server
app.listen(PORT, () => {
  console.log(`Server running at http://localhost:${PORT}`);
});
