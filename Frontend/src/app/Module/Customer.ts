export class CustomerModel {
    constructor(private pId?: string, private name?: string, private adress?: string, private mobile?: string) { }

    public get PId(): string {
        return this.pId;
    }
    public set PId(value: string) {
        this.pId = value;
    }
    public get Name(): string {
        return this.name;
    }
    public set Name(value: string) {
        this.name = value;
    }
    public get Adress(): string {
        return this.adress;
    }
    public set Adress(value: string) {
        this.adress = value;
    }
    public get Mobile(): string {
        return this.mobile;
    }
    public set Mobile(value: string) {
        this.mobile = value;
    }


}