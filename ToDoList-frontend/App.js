import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './App.css';

function App() {
  const [task, setTask] = useState('');
  const [tasks, setTasks] = useState([]);

  useEffect(() => {
    const fetchTasks = async () => {
      try {
        const response = await axios.get('http://localhost:3001/api/task'); 
        setTasks(response.data);
      } catch (error) {
        console.error("Error fetching tasks:", error);
      }
    };

    fetchTasks();
  }, []);

  const handleDeleteTask = async (id) =>{
    try{
      await axios.delete(`http://localhost:3001/api/task/${id}`);
      setTasks(tasks.filter(task => task.id !== id));
    }catch(error){
      console.error('Error deleting task',error);
    }
  }

  const handleAddTask = async () => {
    if (task.trim().length === 0) {
      console.log("Please add a valid task");
      return; 
    }
    try {
      const response = await axios.post('http://localhost:3001/api/task', {
        "title": task,
        "completed": false
      });
      setTasks([...tasks, response.data]);
      setTask('');
    } catch (error) {
      console.error("Error adding task:", error);
    }
  };

  const divStyle = {
    width: '150%',
    border: '5px solid #827a8f',
    padding: '5px',
    margin: '0 auto'
  };

  return (
    <div className="App">
      <header className="App-header">
        <p>Your personalized To-Do List</p>
      </header>
      <div className="App-body">
        <div style={divStyle} className="box1">
          <div className="box2">
            <textarea
              placeholder="Write your task"
              style={{ flex: 1, width: '100%', height: '100%', padding: '5%', border: 'none' }}
              value={task}
              onChange={(e) => setTask(e.target.value)}
            />
            <button onClick={handleAddTask} className="buton1">Add task</button>
          </div>
          <div>
            <ul>
              {tasks.map((task) => (
                <li key={task.id} style = {{marginBottom: '5%'}}>
                  <div style = {{display: 'flex', justifyContent: 'space-between', alignItems: 'center', border: '1px solid black',borderRadius: '0.5em', padding: '3%'}}>{task.title}
                    <button className = 'buton2' onClick={() =>handleDeleteTask(task.id)}>Delete Task</button>
                  </div>
              </li>
              ))}
            </ul>
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;
