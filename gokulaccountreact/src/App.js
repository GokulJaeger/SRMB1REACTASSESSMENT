import './App.css';
import AdminLogin from './components/AdminLogin';
import AccountCreation from './components/AccountCreation';
import AccountList from './components/AccountList';
import { Route, Switch } from 'react-router';
import { BrowserRouter as Router } from 'react-router-dom';
import Dashboard from './components/Dashboard';

function App() {
  return (
    <div className="App">

      {/* <Navbar/> */}
      {/* <AdminLogin /> */}
      <Router>
        <Switch>
          <Route path='/' exact component={AdminLogin}></Route>
          <Route path='/dashboard' exact component={Dashboard}></Route>
          <Route path='/AccountCreation' exact component={AccountCreation}></Route>
          <Route path='/AccountList' exact component={AccountList}></Route>
          {/* <Route path='/dashboard' exact component={Dashboard}></Route> */}
        </Switch>
      </Router>
    </div>
  );
}

export default App;
