import { ChangeEventHandler, Component, createRef } from "react";
import { Button, Col, Form, Stack } from "react-bootstrap";
interface InputProps{
    label:string;
    name:string;
    error?:string;
    value?:string;
    type?:string|'text';
    required?:boolean;
    onChange?: ChangeEventHandler| undefined
    md?:number;
    xs?:number;
    lg?:number;
}
interface InputState{
    type:string|'text';
    passwordBtnCaption:string;
}
// Input component
export default class Input extends Component<InputProps,InputState>{
    constructor(props:InputProps){
        super(props);
        this.state={
            type: this.props.type?this.props.type:'text',
            passwordBtnCaption:'Show'
            
        };
    }
    public showPass():void{
        if(this.state.type==='password'){
            this.setState({type:'text',passwordBtnCaption:'Hide'});
        }else{
            this.setState({type:'password',passwordBtnCaption:'Show'});
        }
    }
    render(){
        return(
        <div>
        <Stack direction="horizontal" gap={1} className="align-items-start">
        <Form.Group as={Col}  md={this.props.md} xs={this.props.xs} lg={this.props.lg} className="mb-3" >
        <Form.Label>{this.props.label}</Form.Label>
        <Form.Control type={this.state.type} name={this.props.name} required={this.props.required} onChange={this.props.onChange}/>
        <div className="Input-Error">{this.props.error}</div>
        </Form.Group>
        <div style={{marginTop: '32px'}}>
        {this.props.type==='password'?
        <Button variant="outline-secondary" onClick={()=>this.showPass()}>{this.state.passwordBtnCaption}</Button>
        :null}
        </div>
        </Stack>
        </div>);
    }
}