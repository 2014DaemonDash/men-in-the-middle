class CreateLocations < ActiveRecord::Migration
  def change
    create_table :locations do |t|
      t.integer :zipcode
    end
  end
end
