import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import { BrowserRouter, Route, Routes} from 'react-router-dom'
import PageNotFound from './components/PageNotFound';
import AddNewBook from './components/pages/AddNewBook';
import ShowCategories from './components/pages/ShowCategories';

const root = ReactDOM.createRoot(document.getElementById('root'));
const apiUrl = 'http://localhost:8080/api';
root.render(
  <BrowserRouter>
      <Routes>
        <Route path='/' element={<App apiUrl={apiUrl} />}>
          <Route path='books' element={<App apiUrl={apiUrl} />} />
        </Route>
        <Route path='addNewBook' element={<AddNewBook apiUrl={apiUrl} />} />
        <Route path='editBook/:id' element={<AddNewBook apiUrl={apiUrl} />} />
        <Route path='categories' element={<ShowCategories apiUrl={apiUrl} />} />
        <Route path='*' element={<PageNotFound />} />
      </Routes>
  </BrowserRouter>
);


// root.render(
//   <React.StrictMode>
//     <App />
//   </React.StrictMode>
// );