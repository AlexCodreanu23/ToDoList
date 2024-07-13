const express = require('express');
const cors = require('cors');
const axios = require('axios');

const app = express();
app.use(cors());
app.use(express.json());


app.post('/api/task', async (req, res) => {
  try {
    const newTask = {
      title: req.body.title,
      completed: req.body.completed
    };

    const response = await axios.post(`http://localhost:8080/api/task`, newTask);
    res.status(201).json(response.data);
  } catch (error) {
    res.status(500).json({ error: 'Something went wrong' });
  }
});

app.get('/api/task', async (req, res) => {
  try {
    const response = await axios.get(`http://localhost:8080/api/task`);
    res.status(200).json(response.data);
  } catch (error) {
    res.status(500).json({ error: 'Something went wrong' });
  }
});

app.delete('/api/task/:id', async(req,res) =>{
  try{
    const {id} = req.params;
    const response = await axios.delete(`http://localhost:8080/api/task/${id}`);
    res.status(200).json(response.data);
  }
  catch(error){
      res.status(500).json({error: 'Something went wrong'});
  }
});

app.listen(3001, () => {
  console.log('Server is running on port 3001');
});
