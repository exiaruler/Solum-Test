import { Component, ReactNode } from "react";
import { Form } from "react-bootstrap";
interface FormHandleProps{
    children?:Array<ReactNode>|ReactNode;
    submit:CallableFunction;
}
// Form component to handle form submission
export default class FormHandle extends Component<FormHandleProps>{
    public submit(event:React.FormEvent<HTMLFormElement>):void{
        event.preventDefault();
        if(this.props.submit){
            this.props.submit();
        }
    }
    render(){
        return(
            <div>
            <Form onSubmit={(event:React.FormEvent<HTMLFormElement>)=>this.submit(event)}>
            {this.props.children}
            </Form>
            </div>
        )
    }
}