import { Component, Input, forwardRef,  OnInit } from '@angular/core';
import { ControlValueAccessor, NG_VALUE_ACCESSOR } from '@angular/forms';

const INPUT_FIELD_VALUE_ACCESSOR: any = {
  provide: NG_VALUE_ACCESSOR,
  useExisting: forwardRef(() => InputsComponent),
  multi: true
};

@Component({
  selector: 'app-inputs',
  templateUrl: './inputs.component.html',
  styleUrls: ['./inputs.component.scss'],
  providers: [INPUT_FIELD_VALUE_ACCESSOR]
})
export class InputsComponent implements ControlValueAccessor, OnInit {

  @Input() label: string = '';
  @Input() placeholder = '';
  @Input() icon = '';
  @Input() inputType = '';
  @Input() control: any;

  private _value: string = '';

  get value() {
    return this._value;
  }

  set value(value: any) {
    this._value = value;

    this.onChange(this._value);
  }


  onChange: (_: any) => void = () => {};
  onTouched: () => void = () => {};
  onValidationChange: () => void = () => {};

  constructor() {  }


  ngOnInit(): void {}

  writeValue(value: string): void {
    this.value = value ? value : '';
  }

  registerOnChange(fn: any): void {
    this.onChange = fn
  }

  registerOnTouched(fn: any): void {
    this.onTouched = fn;
  }

  registerOnValidatorChange?(fn: () => void): void {
    this.onValidationChange = fn;
  }



}
