class AddZipcodeToHomes < ActiveRecord::Migration
  def change
    add_column :homes, :zipcode, :integer
  end
end
