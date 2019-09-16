
 interface ITaxConfig {
    minTaxable: number;
    maxTaxable: number;
    minTax:number;
    taxPercent:number;
};
 const BRACKET_1:ITaxConfig={
    minTaxable : 0,
    maxTaxable : 18200,
    minTax: 0,
    taxPercent: 0,
};
 const BRACKET_2:ITaxConfig={
    minTaxable : 18201,
    maxTaxable : 37000,
    minTax: 0,
    taxPercent: 19,
};
 const BRACKET_3:ITaxConfig={
    minTaxable : 37001,
    maxTaxable : 80000,
    minTax: 3572,
    taxPercent: 32.5,
};
 const BRACKET_4:ITaxConfig={
    minTaxable : 80001,
    maxTaxable : 180000,
    minTax: 17547,
    taxPercent: 37,
};
 const BRACKET_5:ITaxConfig={
    minTaxable : 180001,
    maxTaxable : 0,
    minTax: 54457,
    taxPercent: 45,
};

export const TAX_BRACKETS = {
    BRACKET_1,
     BRACKET_2,
    BRACKET_3,
    BRACKET_4,
     BRACKET_5
};

export default TAX_BRACKETS;