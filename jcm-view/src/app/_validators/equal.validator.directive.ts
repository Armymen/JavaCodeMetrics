import { Directive, forwardRef, Attribute } from '@angular/core';
import { Validator, AbstractControl, NG_VALIDATORS } from '@angular/forms';

@Directive({
    selector: '[validateEqual][formControlName],[validateEqual][formControl],[validateEqual][ngModel]',
    providers: [
        { provide: NG_VALIDATORS, useExisting: forwardRef(() => EqualValidator), multi: true }
    ]
})
export class EqualValidator implements Validator {
    constructor( @Attribute('validateEqual') public validateEqual: string,
        @Attribute('reverse') public reverse: string) {
    }

    private get isReverse() {
        if (!this.reverse) return false;
        return this.reverse === 'true' ? true: false;
    }

    validate(control: AbstractControl): { [key: string]: any } {
        let value = control.value;
        let eq = control.root.get(this.validateEqual);

        if (eq && value !== eq.value && !this.isReverse) {
          return {
            validateEqual: false
          }
        }

        if (eq && value === eq.value && this.isReverse) {
            delete eq.errors['validateEqual'];
            if (!Object.keys(eq.errors).length) eq.setErrors(null);
        }

        if (eq && value !== eq.value && this.isReverse) {
            eq.setErrors({
                validateEqual: false
            })
        }

        return null;
    }
}