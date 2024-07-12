const express = require('express');
const cors = require('cors');
const app = express();

app.use(cors()); 

app.use(express.json());

app.post('/api/task', async (req, res) => {
  try {
    const newTask = {
      title: req.body.title,
      completed: req.body.completed
    };

    tasks.push(newTask);
    res.status(201).json(newTask); 
  } catch (error) {
    res.status(500).json({ error: 'Something went wrong' });
  }
});

app.get('/api/task', async (req, res) => {
  try {
    res.status(200).json(tasks);
  } catch (error) {
    res.status(500).json({ error: 'Something went wrong' });
  }
});

const tasks = [];

app.listen(3001, () => {
  console.log('Server is running on port 3001');
});
