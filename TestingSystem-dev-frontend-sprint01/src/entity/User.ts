import { Group } from './Group';
import { Role } from './Role';



export class User {
  userId: number;
  fullName: string;
  email: string;
  mobile: string;
  password: string;
  status: number;
  roles:Role[];
  // groupNames: Group[];
  // role:any = [];

  constructor(fullName: string, email: string, mobile: string, password: string,status: number){
    this.fullName = fullName;
    this.email =email;
    this.mobile = mobile;
    this.password = password;
    this.status = status;
  }
}
