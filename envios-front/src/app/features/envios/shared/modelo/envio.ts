export interface Envio{
   
    remitente:String;
    receptor:String;
    receptorDireccion:String;
    peso:number;
    envioExpress:boolean;
    idEnvio?:number;
    fechaIngreso?:string;
    fechaEntrega?:string;
    valor?:number;
}