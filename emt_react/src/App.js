import './App.css';
import AddBookButton from './components/AddBookButton';
import BookTable from './components/BookTable';
import { NavLink } from 'react-router-dom';

function App({apiUrl}) {
  return (
    <div className="App" style={{
      marginTop: '50px',
      marginLeft: '30px'
    }}>
      <NavLink to="/categories" style={{position: 'absolute', left: '30px', top: '10px'}}>Categories</NavLink>
      <BookTable apiUrl={apiUrl} />
      <AddBookButton />
    </div>
  );
}

export default App;
