import axios from "axios";

const axiosInstance = axios.create({
  baseURL: "http://localhost:8080/", // API base URL
});

axiosInstance.interceptors.request.use((config) => {
  const token = sessionStorage.getItem("jwtToken");
  console.log("Token from sessionStorage:", token);
  if (token) {
    config.headers["Authorization"] = `Bearer ${token}`;
    console.log("Authorization header set:", config.headers["Authorization"]);
  }
  return config;
});

export default axiosInstance;