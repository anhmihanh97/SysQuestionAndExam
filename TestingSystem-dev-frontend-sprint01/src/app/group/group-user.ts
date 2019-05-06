import { User } from 'src/entity/User';


export class GroupUser {
    groupId: number;
    groupName: string;
    createBy: number;
    createDate: Date;
    users: User[];
    userGroups: [];
}
