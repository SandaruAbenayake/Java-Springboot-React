import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './UserManagement.css';

const UserManagement = () => {
    const [users, setUsers] = useState([]);
    const [user, setUser] = useState({ id: '', name: '' });

    useEffect(() => {
        fetchUsers();
    }, []);

    const fetchUsers = async () => {
        const response = await axios.get('http://localhost:8080/api/v1/getuser');
        setUsers(response.data);
    };

    const addUser = async () => {
        await axios.post('http://localhost:8080/api/v1/adduser', user);
        fetchUsers();
        setUser({ id: '', name: '' });
    };

    const updateUser = async () => {
        await axios.put('http://localhost:8080/api/v1/updateuser', user);
        fetchUsers();
        setUser({ id: '', name: '' });
    };

    const deleteUser = async (id) => {
        await axios.delete('http://localhost:8080/api/v1/deleteuser', { data: { id } });
        fetchUsers();
    };

    return (
        <div className="user-container">
            <h1>User Management</h1>
            <div className="form">
                <input
                    type="text"
                    placeholder="ID"
                    value={user.id}
                    onChange={(e) => setUser({ ...user, id: e.target.value })}
                />
                <input
                    type="text"
                    placeholder="Name"
                    value={user.name}
                    onChange={(e) => setUser({ ...user, name: e.target.value })}
                />
                <button onClick={addUser}>Add User</button>
                <button onClick={updateUser}>Update User</button>
            </div>
            <ul>
                {users.map((u) => (
                    <li key={u.id} className="user-item">
                        {u.id} - {u.name}
                        <button onClick={() => deleteUser(u.id)}>Delete</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default UserManagement;
