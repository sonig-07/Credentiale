import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api/v1/passwords';

export const savePassword = (username, password) => {
  return axios.post(API_BASE_URL, null, {
    params: {
      username: username,
      password: password
    }
  });
};

export const getPasswords = () => {
  return axios.get(API_BASE_URL);
};
