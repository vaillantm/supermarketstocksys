import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './App.css'; // Import your CSS
import App from './App.jsx'



createRoot(document.getElementById('root')).render(
  <StrictMode>
    <App />
  </StrictMode>,
)




