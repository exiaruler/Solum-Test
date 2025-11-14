import { Col, Row, Button } from "react-bootstrap";

interface WelcomeProps{
    email:string;
    logout:React.MouseEventHandler<HTMLButtonElement>;
}
export default function Welcome(props:WelcomeProps){
    return(
        <Col  md={{ span: 6, offset: 3 }} xs={{ span: 10, offset: 1 }} lg={{ span: 6, offset: 3 }}>
        <Row>
        <Col className='mt-2' md={{ span: 8, offset: 2 }} xs={{ span: 11, offset: 1 }}>
        <h1>Welcome {props.email}</h1>
        </Col>
        <Row>
        <Col xs={{ span: 2, offset: 5 }} md={{ span: 2, offset: 5 }} className='justify-content-center mt-3'>
        <div>
        <Button variant="outline-primary" onClick={props.logout}>Logout</Button>
        </div>
        </Col>
        </Row>
        </Row>
        </Col>
    )
}