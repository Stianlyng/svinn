import axios from "axios";

const axiosInstance = axios.create({
  baseURL: "http://dev.stian.localhost:8080/", // API base URL
    headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json'
    }
});

axiosInstance.interceptors.request.use((config) => {
  const token = sessionStorage.getItem("jwtToken");
  if (token) {
    config.headers["Authorization"] = `Bearer ${token}`;
  }
  return config;
});

export default axiosInstance;