import { Role } from 'src/entity/Role';

export interface User {
  userId: number;
  fullName: string;
  email: string;
  modbile: string;
  password: string;
  status: number;
  roles:Role[];
}


