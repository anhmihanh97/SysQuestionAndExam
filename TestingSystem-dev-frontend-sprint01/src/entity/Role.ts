import { User } from './User';

export interface Role {
    roleId: number;
    roleName: string;
    users: User[];
}


export interface Menus {
  menuId: number;
  menuName: string;
  menuDescription: string;
  menuFunction: string;
}
export interface RoleMenu {
  id: number;
  role: Role;
  menu: Menus;
}
