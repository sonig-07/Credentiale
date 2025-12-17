import React, { useState } from 'react';
import { savePassword } from '../services/passwordService';

function PasswordPage() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [status, setStatus] = useState({ message: '', type: '' });

  const handleSubmit = async (e) => {
    e.preventDefault();
    setStatus({ message: '', type: '' });

    try {
      await savePassword(username, password);
      setStatus({ message: 'Password saved securely 🔐', type: 'success' });
      setUsername('');
      setPassword('');
    } catch (error) {
      setStatus({ message: 'Failed to save password ❌', type: 'error' });
    }
  };

  return (
    <div className="container">
      <div className="card">
        <h2>Lockr</h2>

        <form onSubmit={handleSubmit}>
          <div className="input-group">
            <input
              type="text"
              placeholder="Username"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              required
            />
          </div>

          <div className="input-group">
            <input
              type="password"
              placeholder="Password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>

          <button type="submit">Save Password</button>
        </form>

        {status.message && (
          <p className={status.type}>{status.message}</p>
        )}
      </div>
    </div>
  );
}

export default PasswordPage;
