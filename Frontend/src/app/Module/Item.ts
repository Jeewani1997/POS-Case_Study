export class ItemModel {
    constructor(private pId?: string, private name?: string, private qtity?: string, private uPrice?: string) { }

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
    public get Qtity(): string {
        return this.qtity;
    }
    public set Qtity(value: string) {
        this.qtity = value;
    }
    public get UPrice(): string {
        return this.uPrice;
    }
    public set UPrice(value: string) {
        this.uPrice = value;
    }

}