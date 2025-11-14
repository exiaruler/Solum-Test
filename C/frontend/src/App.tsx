import React, { useState } from 'react';
import './App.css';
import { Button, Col, Container, Row } from 'react-bootstrap';
import FormHandle from './components/FormHandle';
import Input from './components/Input';
import Welcome from './landing/Welcome';
// login form interface
interface LoginForm{
  email:string;
  password:string;
  emailError:string;
  passwordError:string;
}
function App() {
  // valid credentials to login
  const validCred={
    email:'helloworld@gmail.com',
    password:'Helloworld123!'
  };
  const [loginForm,setLoginForm]=useState<LoginForm>({email:'',password:'',emailError:'',passwordError:''});
  const [login,setLogin]=useState<boolean>(false);

  const clearErrors=():void=>{
    setLoginForm({...loginForm,emailError:'',passwordError:''});
  }
  // login submit handler
  const loginSubmit=():void=>{
    clearErrors();
    let email=loginForm.email.toLowerCase();
    let spChara=['@','$' ,'!','%','*','?','&','-','_'];
    // check email first if it exists
    if(email===validCred.email){
      // validate password
      let passValid=validatePassword(loginForm.password);
      if(passValid&&loginForm.password===validCred.password){
        setLogin(true);
      }else
      {
       if(!passValid){
         setLoginForm({...loginForm,passwordError:'Password does not meet the criteria of 8-16 characters, at least one uppercase letter, one lowercase letter, one number and one symbol character ( '+spChara.join(', ')+' )',emailError:''});
        }else setLoginForm({...loginForm,passwordError:'Incorrect password',emailError:''});
      }
    }else setLoginForm({...loginForm,emailError:'Email not found'});
    
  }
  // handle form input on change
  const onChange=(name:string,value:string):void=>{
    setLoginForm({...loginForm,[name]:value});
  }
  // validate password regex
  const validatePassword=(password:string):boolean=>{
    let valid=false;
    let validCase =/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[!@#$%^&*()_\-+=\[\]{};':"\\|,.<>/?])[A-Za-z\d@$!%*?&-_\-+=\[\]{};':"\\|,.<>/?]{8,16}$/
    if(validCase.test(password))valid=true;
    return valid;
  }
  const logout=():void=>{
    setLogin(false);
  }
  return (
    <div>
    <Container className="d-flex mt-5 Container">
    <Row className="w-100" >
      {!login?
      <Col md={{ span: 8, offset: 4 }} xs={{ span: 12, offset: 2 }} lg={{ span: 6, offset: 5 }}  >
      <FormHandle submit={loginSubmit}>
      <Input label="Email" name="email" required={true} onChange={(event:React.ChangeEvent<HTMLInputElement>)=>onChange(event.target.name,event.target.value)} error={loginForm.emailError} md={6} xs={8} lg={6}/>
      <Input label="Password" name="password" type="password" onChange={(event:React.ChangeEvent<HTMLInputElement>)=>onChange(event.target.name,event.target.value)} error={loginForm.passwordError} md={6} xs={8} lg={6} />
      <Row >
      <Col md={{ span: 4, offset: 1 }} xs={{ span: 6, offset: 2 }} lg={{ span: 5, offset: 1 }} className='mt-2' >
      <div>
      <a href='/'>Forgot Password</a>
      </div>
      </Col>
      </Row>
      <Row style={{marginLeft:'1rem'}}>
      <Col md={{ span: 3, offset: 1 }} xs={{ span: 2, offset: 2 }} lg={{ span: 2, offset: 1 }} className='mt-2'>
      <div>
      <Button variant="outline-primary" type='submit'>Login</Button>
      </div>
      </Col>
      </Row>  
      </FormHandle>
      </Col>
      :null}
      {login?
      <Welcome email={validCred.email} logout={logout}/>
      :null}
    </Row>
    </Container>
    </div>
  );
}

export default App;
